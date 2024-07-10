import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.initScreenComponents();
    }

    public void initScreenComponents() {
        this.setBackground(Color.WHITE);
        JButton instructionsButton = new JButton(TranslationsUtils.getTranslation(TranslationKeys.instructions));
        this.setLayout(null);
        instructionsButton.setBounds(
                Constants.INSTRUCTIONS_BUTTON_STARTING_X, Constants.INSTRUCTIONS_BUTTON_STARTING_Y,
                Constants.INSTRUCTIONS_BUTTON_WIDTH, Constants.INSTRUCTIONS_BUTTON_HEIGHT);
        this.add(instructionsButton);
        instructionsButton.addActionListener((event) -> {
            String translation = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_1),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_2),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_3),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_4),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_5),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_6),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_7),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_8),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_9),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_10),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_11),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_12),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_13),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_14),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_15),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_16),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_17),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_18),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_19),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_20),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_21),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_22),
                    TranslationsUtils.getTranslation(TranslationKeys.instructions_1_23)

            );
            JOptionPane pane = new JOptionPane(translation, JOptionPane.INFORMATION_MESSAGE);
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            JDialog dialog = pane.createDialog(this, translation);
            dialog.setVisible(true);
        });
        JButton question1 = new JButton(TranslationsUtils.getTranslation(TranslationKeys.question_1));
        question1.setBounds(
                Constants.INSTRUCTIONS_BUTTON_STARTING_X, Constants.INSTRUCTIONS_BUTTON_STARTING_Y + Constants.INSTRUCTIONS_BUTTON_HEIGHT,
                Constants.INSTRUCTIONS_BUTTON_WIDTH, Constants.INSTRUCTIONS_BUTTON_HEIGHT);
        this.add(question1);
        question1.addActionListener(event -> {
            try {
                ExtraResponse response = HttpUtils.question1();
                String text = response.isSuccess() ? TranslationsUtils.getQuestion(Integer.parseInt(response.getExtra())) : TranslationsUtils.getTranslation(TranslationKeys.general_error);
                JOptionPane pane = new JOptionPane(text, JOptionPane.INFORMATION_MESSAGE);
                pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                JDialog dialog = pane.createDialog(this, text);
                dialog.setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        JButton question2 = new JButton(TranslationsUtils.getTranslation(TranslationKeys.question_2));
        question2.setBounds(
                Constants.INSTRUCTIONS_BUTTON_STARTING_X, Constants.INSTRUCTIONS_BUTTON_STARTING_Y + Constants.INSTRUCTIONS_BUTTON_HEIGHT * 2,
                Constants.INSTRUCTIONS_BUTTON_WIDTH, Constants.INSTRUCTIONS_BUTTON_HEIGHT);
        this.add(question2);
        question2.addActionListener(event -> {
            try {
                ExtraResponse response = HttpUtils.question2();
                String text = response.isSuccess() ? TranslationsUtils.getQuestion(Integer.parseInt(response.getExtra())) : TranslationsUtils.getTranslation(TranslationKeys.general_error);
                JOptionPane pane = new JOptionPane(text, JOptionPane.INFORMATION_MESSAGE);
                pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                JDialog dialog = pane.createDialog(this, text);
                dialog.setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


        JButton moveToStage2 = new JButton(TranslationsUtils.getTranslation(TranslationKeys.instructions_stage_2));
        moveToStage2.setBounds(
                Constants.INSTRUCTIONS_BUTTON_STARTING_X, Constants.INSTRUCTIONS_BUTTON_STARTING_Y + Constants.INSTRUCTIONS_BUTTON_HEIGHT * 4,
                Constants.INSTRUCTIONS_BUTTON_WIDTH, Constants.INSTRUCTIONS_BUTTON_HEIGHT);
        this.add(moveToStage2);
        moveToStage2.addActionListener(event -> {
            try {
                String translation = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_1),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_2),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_3),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_4),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_5),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_6),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_7),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_8),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_9),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_10),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_11),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_12),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_13),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_14),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_15),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_16),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_17),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_18),
                        TranslationsUtils.getTranslation(TranslationKeys.instructions_2_19)
                );
                JOptionPane pane = new JOptionPane(translation, JOptionPane.INFORMATION_MESSAGE);
                pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                JDialog dialog = pane.createDialog(this, translation);
                dialog.setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        JButton myImage = new JButton(TranslationsUtils.getTranslation(TranslationKeys.my_image));
        myImage.setBounds(
                Constants.INSTRUCTIONS_BUTTON_STARTING_X, Constants.INSTRUCTIONS_BUTTON_STARTING_Y + Constants.INSTRUCTIONS_BUTTON_HEIGHT * 5,
                Constants.INSTRUCTIONS_BUTTON_WIDTH, Constants.INSTRUCTIONS_BUTTON_HEIGHT);
        this.add(myImage);
        myImage.addActionListener(event -> {
            try {
                ExtraResponse response = HttpUtils.myImage();
                String text = response.isSuccess() ? response.getExtra() : TranslationsUtils.getTranslation(TranslationKeys.general_error);
                JOptionPane pane = new JOptionPane(text, JOptionPane.INFORMATION_MESSAGE);
                pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                JDialog dialog = pane.createDialog(this, text);
                dialog.setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


    }
}
