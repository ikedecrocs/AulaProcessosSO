package view;

import controller.OperacoesController;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperacoesController op = new OperacoesController();
		//op.os();
		//String path = "regedit.exe";	//Existem processos mapeados --> sem necessidade de path pr�vio (c:// ...)
		//op.callProcess(path);			//3 situa��es: 1 - Sucesso, 2 - Caminho errado(id=2), 3 - Sem Permiss�o(Ex.: regedit.exe)(id=740)
		//String comando = "ping www.google.com.br";
		//op.readProcess(comando);
		String matar = "notepad.exe";
		op.killProcess(matar);
	}

}
