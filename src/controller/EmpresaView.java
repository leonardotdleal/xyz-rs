package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Empresa;
import app.Main;
import dao.EmpresaDAO;

public class EmpresaView extends javax.swing.JFrame {

	    public EmpresaView() {
	        initComponents();
	        carregarEmpresas();
	    }

	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        tabela = new javax.swing.JTable();
	        jButton1 = new javax.swing.JButton();

	        setDefaultCloseOperation(close());
	        setResizable(false);

	        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel1.setText("XYZ");

	        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel2.setText("Visualizar Empresas");

	        tabela.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                null
	            },
	            new String [] {
	                "id", "razao social"
	            }
	        ));
	        jScrollPane1.setViewportView(tabela);

	        jButton1.setText("Voltar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
	                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addContainerGap())
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addGap(197, 197, 197))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jLabel2)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addContainerGap())
	        );

	        pack();
	    }// </editor-fold>//GEN-END:initComponents

	    
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	        close();
	        this.dispose();
	    }//GEN-LAST:event_jButton1ActionPerformed

	    
	    int close(){
	        Main.showMainWindow();
	        return DISPOSE_ON_CLOSE; 
	    }

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable tabela;
	    // End of variables declaration//GEN-END:variables
	
	public void carregarEmpresas() {
		EmpresaDAO dao = new EmpresaDAO();
        ArrayList<Empresa> empresas = dao.getAllEmpresa();
        
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        while( modelo.getRowCount() > 0 )
            modelo.removeRow( 0 );

        for( Empresa e : empresas ){
            modelo.addRow( new Object[]{e.getId(), e.getRazaoSocial()} );
        }
	}

}
