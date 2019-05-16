 
package gui;
 
import entities.Cliente;
import entities.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FuncionarioTabela extends AbstractTableModel{
    
     private List<Funcionario> dados = new ArrayList<>();
    private final String[] colunas = {"ID","Nome","Cpf","Telefone", "Email"};
    @Override
    public String getColumnName(int coluna){
      return colunas[coluna];  
    }
        
    public void addRow(Funcionario c){
         this.dados.clear();
        dados.add(c);
        fireTableDataChanged();
    }
    
    public void addRow(List<Funcionario> c){
         this.dados.clear();
        dados = c;
        fireTableDataChanged();
    }
    
    public void removerRow(){
        
        fireTableRowsDeleted(0, getRowCount());
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getId();
            case 1:
            return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getCpf();
            case 3:
                return dados.get(linha).getTelefone();
            case 4:
                return dados.get(linha).getEmail();
        }
        return null;
    }
    
    @Override
     public void setValueAt(Object valor, int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setId(Integer.parseInt((String)valor));
                break;
            case 1:
                dados.get(linha).setNome((String)valor);
                break;
            case 2:
                dados.get(linha).setCpf((String) valor);
                break;
            case 3:
                dados.get(linha).setTelefone((String) valor);
                break;
            case 4:
                dados.get(linha).setEmail((String) valor);
        }
        fireTableRowsUpdated(linha, linha);
    }
    
}
