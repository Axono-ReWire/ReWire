import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Dashboard {

    private static final Color PRIMARY = new Color(0x59BE8B);
    private static final Color SECONDARY = new Color(0x1A6A82);
    private static final Color BG = new Color(0xFCFBFB);
    private static final Color CARD = Color.WHITE;
    private static final Color TEXT = new Color(0x111827);

    private static final String FONT_FAMILY = "SansSerif";

    public Dashboard() {
        createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame("Axono ReWire Dashboard");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1100, 800);
        frame.setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BG);

        // Wrapper panel to center everything
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapper.setBackground(BG);

        wrapper.add(createMainContent());

        root.add(wrapper, BorderLayout.CENTER);

        frame.add(root);
        frame.setVisible(true);
    }

    private JPanel createMainContent() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(BG);
        container.setBorder(new EmptyBorder(60, 20, 60, 20));
        container.setPreferredSize(new Dimension(800, 650));

        container.add(createBanner());
        container.add(Box.createVerticalStrut(40));
        container.add(createProgressSection());
        container.add(Box.createVerticalStrut(40));
        container.add(createRecommendedTopics());

        return container;
    }

    private JPanel createBanner() {
        JPanel banner = new JPanel();
        banner.setLayout(new BoxLayout(banner, BoxLayout.Y_AXIS));
        banner.setBackground(BG);
        banner.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcome = new JLabel("Welcome, {{username}}!");
        welcome.setFont(new Font(FONT_FAMILY, Font.BOLD, 32));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        buttons.setBackground(BG);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttons.add(createOutlineButton("Profile"));
        buttons.add(Box.createHorizontalStrut(10));
        buttons.add(createOutlineButton("Logout"));

        banner.add(welcome);
        banner.add(Box.createVerticalStrut(20));
        banner.add(buttons);

        return banner;
    }

    private JPanel createProgressSection() {
        JPanel section = new JPanel();
        section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
        section.setBackground(BG);
        section.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel pageTitle = new JLabel("Your Learning Dashboard");
        pageTitle.setFont(new Font(FONT_FAMILY, Font.BOLD, 28));
        pageTitle.setForeground(TEXT);
        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Your Progress");
        title.setFont(new Font(FONT_FAMILY, Font.BOLD, 22));
        title.setForeground(TEXT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel card = createCard();
        card.add(new JLabel("{{module_name}}: {{completion_percentage}}% Complete"));

        section.add(pageTitle);
        section.add(Box.createVerticalStrut(20));
        section.add(title);
        section.add(Box.createVerticalStrut(15));
        section.add(card);

        return section;
    }

    private JPanel createRecommendedTopics() {
        JPanel section = new JPanel();
        section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
        section.setBackground(BG);
        section.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Recommended Topics");
        title.setFont(new Font(FONT_FAMILY, Font.BOLD, 22));
        title.setForeground(TEXT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel card = createCard();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        header.setBackground(CARD);

        JLabel icon = new JLabel("📘");
        icon.setFont(new Font(FONT_FAMILY, Font.PLAIN, 26));

        JLabel topic = new JLabel("Electronics");
        topic.setFont(new Font(FONT_FAMILY, Font.BOLD, 20));
        topic.setForeground(SECONDARY);

        header.add(icon);
        header.add(topic);

        JPanel moduleList = new JPanel();
        moduleList.setLayout(new BoxLayout(moduleList, BoxLayout.Y_AXIS));
        moduleList.setBackground(CARD);

        moduleList.add(createModuleCard("Continue: Analogue Electronics", "Resume Lesson"));
        moduleList.add(Box.createVerticalStrut(15));
        moduleList.add(createModuleCard("Explore Other Topics", "Browse All"));

        card.add(header);
        card.add(Box.createVerticalStrut(20));
        card.add(moduleList);

        section.add(title);
        section.add(Box.createVerticalStrut(20));
        section.add(card);

        return section;
    }

    private JPanel createModuleCard(String title, String buttonText) {
        JPanel card = createCard();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel label = new JLabel(title);
        label.setFont(new Font(FONT_FAMILY, Font.BOLD, 15));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton button = createOutlineButton(buttonText);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(label);
        card.add(Box.createVerticalStrut(10));
        card.add(button);

        return card;
    }

    private JPanel createCard() {
        JPanel card = new JPanel();
        card.setBackground(CARD);
        card.setLayout(new FlowLayout(FlowLayout.LEFT));
        card.setMaximumSize(new Dimension(700, 200));
        card.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                new EmptyBorder(20, 20, 20, 20)));

        return card;
    }

    private JButton createOutlineButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(CARD);
        btn.setForeground(PRIMARY);
        btn.setBorder(BorderFactory.createLineBorder(PRIMARY, 2));
        btn.setFont(new Font(FONT_FAMILY, Font.BOLD, 14));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dashboard::new);
    }
}