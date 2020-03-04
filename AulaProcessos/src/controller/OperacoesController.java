package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OperacoesController {

	public OperacoesController() {
		super();
	}

	public void os() {
		String os = System.getProperty("os.name");
		String ver = System.getProperty("os.version");
		String arch = System.getProperty("os.arch");
		System.out.println(os + ", Versão: " + ver + ", Arquitetura: " + arch);
	}

	public void callProcess(String path) {
		try {
			Runtime.getRuntime().exec(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if (e.getMessage().contains("740")) {
				// id=740
				StringBuffer str = new StringBuffer();
				str.append("cmd /c");
				str.append(" ");
				str.append(path);
				try {
					Runtime.getRuntime().exec(str.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				}
			} else {
				// id=2
				System.err.println("File not found");
			}
		}
	}

	public void readProcess(String command) {
		try {
			Process p = Runtime.getRuntime().exec(command);
			InputStream stream = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String saida = buffer.readLine();
			while (saida != null) {
				System.out.println(saida);
				saida = buffer.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Comando não encontrado");
		}
	}

	public void killProcess(String param) {
		String cmdPid = "TASKKILL /PID";		//lista de PID -> tasklist /fo table
		String cmdNome = "TASKKILL /IM";
		StringBuffer buffer = new StringBuffer();
		int pid=0;
		try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		}catch(NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
		callProcess(buffer.toString());
	}

}
