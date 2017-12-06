package controller;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Empresa;
import app.Main;
import dao.EmpresaDAO;


public class EmpresaCreate extends javax.swing.JFrame {
    boolean ehCadastro = true;
    
    /**
     * Creates new form CadastrarEmpresa
     */
    public EmpresaCreate(boolean cadastrar) {
        ehCadastro = cadastrar;
        initComponents();
        
        if( cadastrar ){
            rotuloTitulo.setText("Cadastrar Empresa");
            botaoAcao.setText("Cadastrar");
        } else {
            rotuloTitulo.setText("Alterar Empresa");
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
        botaoAcao = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        textFieldRazaoSocial = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("XYZ");

        rotuloTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        rotuloTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rotuloTitulo.setText("T�tulo");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jLabel3.setText("Raz�o Social:");

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
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(textFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAcao)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void getCodigoEmpresa(){
        Empresa empresa = null;
        do{
            String entrada = JOptionPane.showInputDialog(this, "Digite o c�digo do empresa ou 0 (zero)\n"
                + "para retornar ao menu principal.", "Alterar Empresa",
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
                EmpresaDAO dao = new EmpresaDAO();
                empresa = dao.getEmpresa(id);
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
        
        Empresa empresa = new Empresa(textFieldRazaoSocial.getText());
        
        EmpresaDAO dao = new EmpresaDAO();
        boolean resultado = dao.cadastrarEmpresa(empresa);
        
        if( resultado == false ) {
            showErroBD();
            return;
        }
        
        int opcao = JOptionPane.showConfirmDialog(this, "Empresa adicionado com sucesso.\n"
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
        if( textFieldRazaoSocial.isEnabled() ){
        	 EmpresaDAO dao = new EmpresaDAO();
        	 ArrayList<Empresa> empresas = dao.getEmpresaPorRazaoSocial(textFieldRazaoSocial.getText());
             
            if( empresas == null ){
                JOptionPane.showMessageDialog(this, "Nenhum empresa foi encontrado com nome!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
            	for( Empresa e : empresas ){
                    textFieldRazaoSocial.setText( e.getRazaoSocial() );
                    botaoAcao.setText("Alterar");
                }
            }
        }
/*
        else{ // realizar altera��o na tabela
            if( verificarErros() ){
                showErroPreenchimento();
                return;
            }
            int codp, idade;
            try{
                codp = Integer.parseInt( textFieldCod.getText() );
                idade = Integer.parseInt( textFieldIdade.getText() );
            } catch ( NumberFormatException ex ){
                showErroPreenchimento();
                return;
            }
            Empresa empresa = new Empresa(codp, textFieldRazaoSocial.getText(), textFieldCPF.getText(), idade, textFieldCidade.getText());
            boolean resultado = Main.getBD().alterarEmpresa(empresa);
            if( resultado == false ){
                showErroBD();
                return;
            }
            int opcao = JOptionPane.showConfirmDialog(this, "Dados alterados com sucesso.\n"
                    + "Deseja alterar outro registro?", "Opera��o Realizada com Sucesso", JOptionPane.YES_NO_OPTION);
            if( opcao == JOptionPane.YES_OPTION ){
                limpaCampos();
                alterarEdicaoCampos( false );
                textFieldCod.setEnabled( true );
                botaoAcao.setText("Consultar");
            }
            else{
                Main.showMainWindow();
                this.dispose();
            }
        }*/
    }
    
    private boolean verificarErros(){
        if( textFieldRazaoSocial.getText().length()<=3 ){
            showErroPreenchimento();
            return true;
        }
        return false;
    }
    
    private void showErroPreenchimento(){
        JOptionPane.showMessageDialog(this, "Verifique o preenchimento dos dados!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    private void showErroBD(){
        JOptionPane.showMessageDialog(this, "Ocorreu algum erro ao registrar dados no BD!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    private void limpaCampos(){
        textFieldRazaoSocial.setText("");
    }
    
    private void alterarEdicaoCampos(boolean opcao){
        textFieldRazaoSocial.setEnabled( opcao );
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel rotuloTitulo;
    private javax.swing.JTextField textFieldRazaoSocial;
    // End of variables declaration//GEN-END:variables
}
