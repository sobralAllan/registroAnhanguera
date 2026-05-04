package registro;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao;
		do {
			ControlPessoa controle = new ControlPessoa();//Criação do construtor vazio
			opcao = controle.menu();
			
			switch(opcao) {
			case 1:
				controle.cadastrarTela();
				break;
			case 2:	
				controle.ConsultarBanco();
				break;
			case 3:
				controle.AtualizarBanco();
				break;
			case 4:
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o código: ", "Código", 
                        JOptionPane.QUESTION_MESSAGE));
				controle.ExcluirBanco(codigo);
				break;
			}//fim switch
		}while(opcao != 0);
	}//fim método main
}//fim da classe main
