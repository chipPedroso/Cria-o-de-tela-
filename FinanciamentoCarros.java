import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class FinanciamentoCarros extends JFrame {

    // =========================
    // COMPONENTES
    // =========================

    private JComboBox<String> comboMarca;
    private JTextField campoModelo;
    private JComboBox<Integer> comboAno;
    private JTextField campoValor;

    private JRadioButton radioNovo;
    private JRadioButton radioUsado;

    private JPanel painelUsado;
    private JTextField campoQuilometragem;
    private JTextField campoProprietarios;

    private JCheckBox checkEntrada;
    private JLabel labelEntrada;
    private JTextField campoEntrada;

    private JComboBox<Integer> comboParcelas;

    private JPanel painelResultado;
    private JLabel labelValorFinanciado;
    private JLabel labelValorParcela;
    private JLabel labelTotalPagar;

    // Taxa utilizada no financiamento
    private static final double TAXA = 0.10;

    // Formatação de dinheiro brasileiro
    private final NumberFormat formatoMoeda =
            NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));


    // =========================
    // CONSTRUTOR
    // =========================

    public FinanciamentoCarros() {

        setTitle("Financiamento de Carros");
        setSize(600, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        criarTela();
    }


    // =========================
    // CRIAÇÃO DA TELA
    // =========================

    private void criarTela() {

        // Layout principal
        setLayout(new BorderLayout(10, 10));

        // ==========================================
        // TÍTULO
        // ==========================================

        JLabel titulo = new JLabel(
                "Financiamento de Carros",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        add(titulo, BorderLayout.NORTH);


        // ==========================================
        // PAINEL PRINCIPAL
        // ==========================================

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(
                painelPrincipal,
                BoxLayout.Y_AXIS
        ));

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );


        // ==========================================
        // DADOS DO VEÍCULO
        // ==========================================

        JPanel painelDadosVeiculo = new JPanel(
                new GridBagLayout()
        );

        painelDadosVeiculo.setBorder(
                BorderFactory.createTitledBorder("Dados do Veículo")
        );

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // Marca
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelDadosVeiculo.add(new JLabel("Marca:"), gbc);

        comboMarca = new JComboBox<>(
                new String[]{
                        "FIAT",
                        "Volkswagen",
                        "Chevrolet",
                        "Toyota",
                        "Honda",
                        "Ford"
                }
        );

        gbc.gridx = 1;
        gbc.weightx = 1;
        painelDadosVeiculo.add(comboMarca, gbc);


        // Modelo
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;

        painelDadosVeiculo.add(new JLabel("Modelo:"), gbc);

        campoModelo = new JTextField();

        gbc.gridx = 1;
        gbc.weightx = 1;

        painelDadosVeiculo.add(campoModelo, gbc);


        // Ano
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;

        painelDadosVeiculo.add(new JLabel("Ano:"), gbc);

        comboAno = new JComboBox<>();

        // Anos de 2026 até 2000
        for (int ano = 2026; ano >= 2000; ano--) {
            comboAno.addItem(ano);
        }

        gbc.gridx = 1;
        gbc.weightx = 1;

        painelDadosVeiculo.add(comboAno, gbc);


        // Valor
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;

        painelDadosVeiculo.add(new JLabel("Valor:"), gbc);

        campoValor = new JTextField();

        gbc.gridx = 1;
        gbc.weightx = 1;

        painelDadosVeiculo.add(campoValor, gbc);


        painelPrincipal.add(painelDadosVeiculo);


        // ==========================================
        // TIPO DO VEÍCULO
        // ==========================================

        JPanel painelTipo = new JPanel(
                new FlowLayout(FlowLayout.LEFT)
        );

        painelTipo.setBorder(
                BorderFactory.createTitledBorder("Tipo")
        );

        radioNovo = new JRadioButton("Novo");
        radioUsado = new JRadioButton("Usado");

        radioNovo.setSelected(true);

        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(radioNovo);
        grupoTipo.add(radioUsado);

        painelTipo.add(radioNovo);
        painelTipo.add(radioUsado);

        painelPrincipal.add(painelTipo);


        // ==========================================
        // DADOS DO VEÍCULO USADO
        // ==========================================

        painelUsado = new JPanel(
                new GridBagLayout()
        );

        painelUsado.setBorder(
                BorderFactory.createTitledBorder(
                        "Dados do Veículo Usado"
                )
        );

        GridBagConstraints usadoGbc = new GridBagConstraints();

        usadoGbc.insets = new Insets(5, 5, 5, 5);
        usadoGbc.fill = GridBagConstraints.HORIZONTAL;


        // Quilometragem
        usadoGbc.gridx = 0;
        usadoGbc.gridy = 0;

        painelUsado.add(
                new JLabel("Quilometragem:"),
                usadoGbc
        );

        campoQuilometragem = new JTextField();

        usadoGbc.gridx = 1;
        usadoGbc.weightx = 1;

        painelUsado.add(
                campoQuilometragem,
                usadoGbc
        );


        // Proprietários
        usadoGbc.gridx = 0;
        usadoGbc.gridy = 1;
        usadoGbc.weightx = 0;

        painelUsado.add(
                new JLabel("Proprietários:"),
                usadoGbc
        );

        campoProprietarios = new JTextField();

        usadoGbc.gridx = 1;
        usadoGbc.weightx = 1;

        painelUsado.add(
                campoProprietarios,
                usadoGbc
        );


        painelPrincipal.add(painelUsado);


        // ==========================================
        // FINANCIAMENTO
        // ==========================================

        JPanel painelFinanciamento = new JPanel(
                new GridBagLayout()
        );

        painelFinanciamento.setBorder(
                BorderFactory.createTitledBorder("Financiamento")
        );

        GridBagConstraints finGbc = new GridBagConstraints();

        finGbc.insets = new Insets(5, 5, 5, 5);
        finGbc.fill = GridBagConstraints.HORIZONTAL;


        // Possui entrada
        checkEntrada = new JCheckBox("Possui entrada?");

        finGbc.gridx = 0;
        finGbc.gridy = 0;
        finGbc.gridwidth = 2;

        painelFinanciamento.add(
                checkEntrada,
                finGbc
        );


        // Entrada
        labelEntrada = new JLabel("Entrada:");

        finGbc.gridx = 0;
        finGbc.gridy = 1;
        finGbc.gridwidth = 1;

        painelFinanciamento.add(
                labelEntrada,
                finGbc
        );

        campoEntrada = new JTextField();

        finGbc.gridx = 1;
        finGbc.weightx = 1;

        painelFinanciamento.add(
                campoEntrada,
                finGbc
        );


        // Parcelas
        finGbc.gridx = 0;
        finGbc.gridy = 2;
        finGbc.weightx = 0;

        painelFinanciamento.add(
                new JLabel("Parcelas:"),
                finGbc
        );

        comboParcelas = new JComboBox<>(
                new Integer[]{
                        12,
                        24,
                        36,
                        48,
                        60
                }
        );

        // Seleciona 36 inicialmente
        comboParcelas.setSelectedItem(36);

        finGbc.gridx = 1;
        finGbc.weightx = 1;

        painelFinanciamento.add(
                comboParcelas,
                finGbc
        );


        painelPrincipal.add(painelFinanciamento);


        // ==========================================
        // BOTÕES
        // ==========================================

        JPanel painelBotoes = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 20, 10)
        );

        JButton botaoCalcular = new JButton("CALCULAR");
        JButton botaoLimpar = new JButton("LIMPAR");

        painelBotoes.add(botaoCalcular);
        painelBotoes.add(botaoLimpar);

        painelPrincipal.add(painelBotoes);


        // ==========================================
        // RESULTADO
        // ==========================================

        painelResultado = new JPanel(
                new GridLayout(3, 1, 5, 5)
        );

        painelResultado.setBorder(
                BorderFactory.createTitledBorder("Resultado")
        );

        labelValorFinanciado = new JLabel(
                "Valor financiado:"
        );

        labelValorParcela = new JLabel(
                "Valor da parcela:"
        );

        labelTotalPagar = new JLabel(
                "Total a pagar:"
        );

        painelResultado.add(labelValorFinanciado);
        painelResultado.add(labelValorParcela);
        painelResultado.add(labelTotalPagar);

        // Resultado começa escondido
        painelResultado.setVisible(false);

        painelPrincipal.add(painelResultado);


        // ==========================================
        // SCROLL
        // ==========================================

        JScrollPane scrollPane = new JScrollPane(
                painelPrincipal
        );

        add(scrollPane, BorderLayout.CENTER);


        // ==========================================
        // EVENTOS
        // ==========================================

        // Novo
        radioNovo.addActionListener(e -> {

            painelUsado.setVisible(false);

            atualizarTela();
        });


        // Usado
        radioUsado.addActionListener(e -> {

            painelUsado.setVisible(true);

            atualizarTela();
        });


        // Possui entrada
        checkEntrada.addActionListener(e -> {

            boolean possuiEntrada =
                    checkEntrada.isSelected();

            labelEntrada.setVisible(possuiEntrada);
            campoEntrada.setVisible(possuiEntrada);

            atualizarTela();
        });


        // Calcular
        botaoCalcular.addActionListener(e -> {

            calcularFinanciamento();
        });


        // Limpar
        botaoLimpar.addActionListener(e -> {

            limparFormulario();
        });


        // Inicialmente não possui entrada
        labelEntrada.setVisible(false);
        campoEntrada.setVisible(false);

        // Inicialmente carro novo
        painelUsado.setVisible(false);
    }


    // =========================
    // CÁLCULO
    // =========================

    private void calcularFinanciamento() {

        try {

            // =====================================
            // VALIDAÇÃO DO MODELO
            // =====================================

            String modelo = campoModelo.getText().trim();

            if (modelo.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Informe o modelo do veículo.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                campoModelo.requestFocus();
                return;
            }


            // =====================================
            // VALIDAÇÃO DO VALOR
            // =====================================

            String textoValor =
                    campoValor.getText()
                            .trim()
                            .replace(",", ".");

            if (textoValor.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Informe o valor do veículo.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                campoValor.requestFocus();
                return;
            }

            double valorVeiculo =
                    Double.parseDouble(textoValor);

            if (valorVeiculo <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "O valor do veículo deve ser maior que zero.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                campoValor.requestFocus();
                return;
            }


            // =====================================
            // VALIDAÇÃO DO VEÍCULO USADO
            // =====================================

            if (radioUsado.isSelected()) {

                if (campoQuilometragem
                        .getText()
                        .trim()
                        .isEmpty()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Informe a quilometragem.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );

                    campoQuilometragem.requestFocus();
                    return;
                }

                if (campoProprietarios
                        .getText()
                        .trim()
                        .isEmpty()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Informe a quantidade de proprietários.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );

                    campoProprietarios.requestFocus();
                    return;
                }
            }


            // =====================================
            // ENTRADA
            // =====================================

            double entrada = 0;

            if (checkEntrada.isSelected()) {

                String textoEntrada =
                        campoEntrada
                                .getText()
                                .trim()
                                .replace(",", ".");

                if (textoEntrada.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Informe o valor da entrada.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );

                    campoEntrada.requestFocus();
                    return;
                }

                entrada =
                        Double.parseDouble(textoEntrada);

                if (entrada < 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "A entrada não pode ser negativa.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );

                    campoEntrada.requestFocus();
                    return;
                }

                if (entrada >= valorVeiculo) {

                    JOptionPane.showMessageDialog(
                            this,
                            "A entrada deve ser menor que o valor do veículo.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );

                    campoEntrada.requestFocus();
                    return;
                }
            }


            // =====================================
            // CÁLCULO
            // =====================================

            int numeroParcelas =
                    (Integer) comboParcelas.getSelectedItem();


            // valor_financiado = valor_veiculo - entrada
            double valorFinanciado =
                    valorVeiculo - entrada;


            // valor_total = valor_financiado * (1 + taxa)
            double valorTotal =
                    valorFinanciado * (1 + TAXA);


            // valor_parcela = valor_total / numero_parcelas
            double valorParcela =
                    valorTotal / numeroParcelas;


            // =====================================
            // EXIBIR RESULTADO
            // =====================================

            labelValorFinanciado.setText(
                    "Valor financiado: "
                            + formatoMoeda.format(valorFinanciado)
            );

            labelValorParcela.setText(
                    "Valor da parcela: "
                            + formatoMoeda.format(valorParcela)
            );

            labelTotalPagar.setText(
                    "Total a pagar: "
                            + formatoMoeda.format(valorTotal)
            );

            painelResultado.setVisible(true);

            atualizarTela();


        } catch (NumberFormatException erro) {

            JOptionPane.showMessageDialog(
                    this,
                    "Digite apenas valores numéricos válidos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =========================
    // LIMPAR
    // =========================

    private void limparFormulario() {

        comboMarca.setSelectedIndex(0);

        campoModelo.setText("");

        comboAno.setSelectedIndex(0);

        campoValor.setText("");

        radioNovo.setSelected(true);

        campoQuilometragem.setText("");
        campoProprietarios.setText("");

        checkEntrada.setSelected(false);

        campoEntrada.setText("");

        comboParcelas.setSelectedItem(36);

        labelEntrada.setVisible(false);
        campoEntrada.setVisible(false);

        painelUsado.setVisible(false);

        painelResultado.setVisible(false);

        atualizarTela();
    }


    // =========================
    // ATUALIZAR TELA
    // =========================

    private void atualizarTela() {

        revalidate();
        repaint();
    }


    // =========================
    // MAIN
    // =========================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            FinanciamentoCarros tela =
                    new FinanciamentoCarros();

            tela.setVisible(true);
        });
    }
}