package view;

import java.util.Date;

import javax.swing.JOptionPane;

import model.Candidato;
import app.Main;
import dao.CandidatoDAO;


public class CandidatoCreate extends javax.swing.JFrame {
    boolean ehCadastro = true;
    
    /**
     * Creates new form CadastrarCandidato
     */
    public CandidatoCreate(boolean cadastrar) {
        ehCadastro = cadastrar;
        initComponents();
        
        if( cadastrar ){
            rotuloTitulo.setText("Cadastrar Candidato");
            botaoAcao.setText("Cadastrar");
        } else {
            rotuloTitulo.setText("Alterar Candidato");
            botaoAcao.setText("Consultar");
            alterarEdicaoCampos( true );
        }
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rotuloTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botaoAcao = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        textFieldDataNascimento = new javax.swing.JTextField();
        textFieldCPF = new javax.swing.JTextField();
        textFieldNome = new javax.swing.JTextField();
        textFieldPresensaoSalarial = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("XYZ");

        rotuloTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        rotuloTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rotuloTitulo.setText("T�tulo");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel3.setText("CPF:");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel4.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel5.setText("Data Nascimento:");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel6.setText("Pretens�o Salarial:");

        botaoAcao.setBackground(new java.awt.Color(204, 255, 204));
        botaoAcao.setText("acao");
        
        botaoAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAcaoActionPerformed(evt);
            }
        });

        botaoCancelar.setBackground(new java.awt.Color(255, 153, 153));
        botaoCancelar.setText("Voltar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rotuloTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textFieldDataNascimento)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textFieldPresensaoSalarial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAcao)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rotuloTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(textFieldPresensaoSalarial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAcao)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void getCodigoCandidato(){
        Candidato empresa = null;
        do{
            String entrada = JOptionPane.showInputDialog(this, "Digite o c�digo do empresa ou 0 (zero)\n"
                + "para retornar ao menu principal.", "Alterar Candidato",
                JOptionPane.INFORMATION_MESSAGE);
            System.out.println( entrada );
            
            if( entrada == null || entrada.equals("0") ){
                this.dispose();
                Main.showMainWindow();
            }
            
            // tenta converter o texto digitado para n�mero
            int id = 0;
            try{
                id = Integer.parseInt( entrada );
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Voc� n�o digitou um n�mero estrup�cio!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
            if( id != 0 ) {
                CandidatoDAO dao = new CandidatoDAO();
                //empresa = dao.getCandidato(id);
            }
        } while( empresa == null );
    }
    
    private void botaoAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAcaoActionPerformed
        if( ehCadastro ){
            tratarCadastro();
        } else{ //� altera��o
            tratarAlteracao();
        }
    }//GEN-LAST:event_botaoAcaoActionPerformed

    private void tratarCadastro(){
        if(verificarErros()) {
        	showErroPreenchimento();
        	return;
        }
        
        Candidato candidato = new Candidato(textFieldCPF.getText(),
        									textFieldNome.getText(),
        									textFieldDataNascimento.getText(),
        									Float.parseFloat((textFieldPresensaoSalarial.getText())));
        
        CandidatoDAO dao = new CandidatoDAO();
        boolean resultado = dao.cadastrarCandidato(candidato);
        
        if( resultado == false ) {
            showErroBD();
            return;
        }
        
        int opcao = JOptionPane.showConfirmDialog(this, "Candidato adicionado com sucesso.\n"
                + "Deseja adicionar outro registro?", "Opera��o Realizada com Sucesso", JOptionPane.YES_NO_OPTION);
        if( opcao == JOptionPane.YES_OPTION ){
            limpaCampos();
        }
        else{
            Main.showMainWindow();
            this.dispose();
        }
    }
    
    
    
    private void tratarAlteracao(){
        /*if( textFieldCPF.isEnabled() ){
        	 CandidatoDAO dao = new CandidatoDAO();
        	 ArrayList<Candidato> empresas = dao.getCandidatoPorRazaoSocial(textFieldRazaoSocial.getText());
             
            if( empresas == null ){
                JOptionPane.showMessageDialog(this, "Nenhum empresa foi encontrado com nome!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
            	for( Candidato e : empresas ){
                    textFieldRazaoSocial.setText( e.getRazaoSocial() );
                    botaoAcao.setText("Alterar");
                }
            }
        }*/
/*
        else{ // realizar altera��o na tabela
            if( verificarErros() ){
                showErroPreenchimento();
                return;
            }
            int codp, idade;
            try{
                codp = Integer.parseInt( textFieldDataNascimento.getText() );
                idade = Integer.parseInt( textFieldPresensaoSalarial.getText() );
            } catch ( NumberFormatException ex ){
                showErroPreenchimento();
                return;
            }
            Candidato empresa = new Candidato(codp, textFieldRazaoSocial.getText(), textFieldCPF.getText(), idade, textFieldNome.getText());
            boolean resultado = Main.getBD().alterarCandidato(empresa);
            if( resultado == false ){
                showErroBD();
                return;
            }
            int opcao = JOptionPane.showConfirmDialog(this, "Dados alterados com sucesso.\n"
                    + "Deseja alterar outro registro?", "Opera��o Realizada com Sucesso", JOptionPane.YES_NO_OPTION);
            if( opcao == JOptionPane.YES_OPTION ){
                limpaCampos();
                alterarEdicaoCampos( false );
                textFieldDataNascimento.setEnabled( true );
                botaoAcao.setText("Consultar");
            }
            else{
                Main.showMainWindow();
                this.dispose();
            }
        }*/
    }
    
    private boolean verificarErros(){
        /*if( textFieldRazaoSocial.getText().length()<=3 ){
            showErroPreenchimento();
            return true;
        }*/
        return false;
    }
    
    private void showErroPreenchimento(){
        JOptionPane.showMessageDialog(this, "Verifique o preenchimento dos dados!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    private void showErroBD(){
        JOptionPane.showMessageDialog(this, "Ocorreu algum erro ao registrar dados no BD!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    private void limpaCampos(){
        textFieldCPF.setText("");
        textFieldNome.setText("");
        textFieldDataNascimento.setText("");
        textFieldPresensaoSalarial.setText("");
    }
    
    private void alterarEdicaoCampos(boolean opcao){
    	textFieldCPF.setEnabled( opcao );
        textFieldNome.setEnabled( opcao );
        textFieldDataNascimento.setEnabled( opcao );
        textFieldPresensaoSalarial.setEnabled( opcao );
    }
    
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        int acao = JOptionPane.showConfirmDialog(this, "Voc� tem certeza que deseja voltar?\n"
                + "Todos os dados digitados ser�o perdidos.", "Confirma��o",
                JOptionPane.YES_NO_OPTION );
        
        if( acao == JOptionPane.NO_OPTION ) return;
        
        Main.showMainWindow();
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAcao;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel rotuloTitulo;
    private javax.swing.JTextField textFieldCPF;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldDataNascimento;
    private javax.swing.JTextField textFieldPresensaoSalarial;
    // End of variables declaration//GEN-END:variables
}
