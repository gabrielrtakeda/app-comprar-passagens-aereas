package project.modules.Passenger.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Form.Validator.FormRequiredFieldValidator;
import project.modules.Application.Model.AbstractModel;
import project.modules.Pessenger.DataAccessObject.PassengerDAO;
import project.modules.Passenger.Entity.PassengerEntity;
import project.modules.Passenger.View.Modal.PassengerRegisterModal;
import project.modules.Passenger.Type.SalutationType;
import java.awt.Component;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class PassengerModel extends AbstractModel
{
    public PassengerModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    protected PassengerDAO dao()
    {
        return new PassengerDAO();
    }

    public void register()
    {
        // Pegar componentes por parâmetro.
        Map<String, Component>
            components =
                configuration.getParameter("passenger-register-form-data");

        /**
         * Setar as variáveis de cada componente passado por parâmetro.
         */
        JRadioButton yesResponsibleRadio = (JRadioButton) components.get("responsible-passenger:yes");
        JRadioButton noResponsibleRadio = (JRadioButton) components.get("responsible-passenger:no");
        JComboBox salutationCombo = (JComboBox) components.get("salutation");
        JTextField dateBirth = (JTextField) components.get("birth-date");
        JTextField cpf = (JTextField) components.get("cpf");
        JTextField name = (JTextField) components.get("name");
        JTextField email = new JTextField();
        JTextField phone = new JTextField();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (yesResponsibleRadio.isSelected()) {
            email = (JTextField) components.get("email");
            phone = (JTextField) components.get("phone");
        }
        SalutationType salutation = (SalutationType) salutationCombo.getSelectedItem();

        /**
         * Validação dos Text Fields do formulário de Cadastro de Passageiro.
         */
        List<String> fieldsRequired = new ArrayList<String>();
        fieldsRequired.add(configuration.getTranslator().__("Forma de Tratamento"));
        fieldsRequired.add(configuration.getTranslator().__("Nome Completo"));
        fieldsRequired.add(configuration.getTranslator().__("Data de Nascimento"));

        List<String> valuesRequired = new ArrayList<String>();
        valuesRequired.add(salutation.getValue());
        valuesRequired.add(name.getText());
        valuesRequired.add(dateBirth.getText());

        if (yesResponsibleRadio.isSelected()) {
            fieldsRequired.add(configuration.getTranslator().__("Email"));
            fieldsRequired.add(configuration.getTranslator().__("Telefone"));
            valuesRequired.add(email.getText());
            valuesRequired.add(phone.getText());
        }
        FormRequiredFieldValidator.setConfiguration(configuration);
        FormRequiredFieldValidator.validateFields(
            fieldsRequired.toArray(new String[fieldsRequired.size()]),
            valuesRequired.toArray(new String[valuesRequired.size()])
        );

        /**
         * Exibe mensagem caso haja erro.
         */
        if (FormRequiredFieldValidator.hasError()) {
            FormRequiredFieldValidator.showErrorMessage();
        } else {
            PassengerEntity passengerEntity = new PassengerEntity();
            try {
                /**
                 * Popula Entidade de Passagem.
                 */
                passengerEntity.setSalutation(salutation.getValue())
                               .setFullName(name.getText())
                               .setGender(
                                    convertSalutationToGender(salutation.getValue())
                                )
                               .setDateBirth(dateFormat.parse(dateBirth.getText()))
                               .setProfile(
                                    getProfileByDateBirth(
                                        dateFormat.parse(dateBirth.getText())
                                    )
                                )
                               .setCpf(Long.parseLong(cpf.getText()))
                               .setEmail(email.getText())
                               .setPhone(phone.getText())
                               .setResponsible(yesResponsibleRadio.isSelected() ? true : false);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            configuration.addEntityInCollection(passengerEntity);
            configuration.clearParameters();

            /**
             * Envia os dados para a DAO para persistir no Banco de Dados.
             */
            if (dao().register(passengerEntity)) {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__("Passageiro cadastrado com sucesso!"),
                    configuration.getTranslator().__("Sucesso"),
                    JOptionPane.INFORMATION_MESSAGE
                );
                configuration.disposeModal("passenger-register");
                configuration.clearParameters();
                configuration.setQueryString("passenger-register:responsible-passenger", "false");
                new PassengerRegisterModal(configuration);
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    configuration.getTranslator().__(
                        "Não foi possível finalizar o cadastro do passageiro."
                    ),
                    configuration.getTranslator().__("Erro"),
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private Character convertSalutationToGender(String salutation)
    {
        Character gender = 'F';
        if (salutation.equals(PassengerEntity.SALUTATION_MISTER)) {
            gender = 'M';
        }

        return gender;
    }

    private String getProfileByDateBirth(Date dateBirth)
    {
        Date now = new Date();

        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(dateBirth);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(now);

        Integer diffYears = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        Integer diffMonths = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

        /**
         * Define qual o perfil do Passageiro.
         */
        String profile = PassengerEntity.PROFILE_ADULT;
        if (diffYears <= 1 && diffMonths <= 11)
        {
            profile = PassengerEntity.PROFILE_BABY;
        }
        else if (diffYears >= 2 && diffYears <= 11)
        {
            profile = PassengerEntity.PROFILE_CHILD;
        }
        return profile;
    }
}
