package testes;

import dao.PassageiroDAO;
import dao.VooDAO;

public class TesteRemocao2 {
	public static void main(String[] args) {
		
		PassageiroDAO eiroDao = new PassageiroDAO();
	System.out.println(eiroDao.remover(1L) ? "Sucesso ao remover" : "Ja removido ou inexistente");
	
	
	VooDAO voDao = new VooDAO();
	System.out.println(voDao.remover(2L) ? "Sucesso ao remover" : "Ja removido ou inexistente");
	}

}
