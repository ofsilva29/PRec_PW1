package testes;

import dao.AeroportoDAO;
import dao.VooDAO;
import dao.PassagemDAO;

public class TesteRemocao1 {
	public static void main(String[] args) {
		
		
		AeroportoDAO aeroDao = new AeroportoDAO();
		System.out.println(aeroDao.remover(1L) ? "Sucesso ao remover" : "Ja removido ou inexistente");	
		
		
		VooDAO vooDao = new VooDAO();
		System.out.println(vooDao.remover(2L) ? "Sucesso ao remover" : "Ja removido ou inexistente");
		
		
		PassagemDAO passDao = new PassagemDAO();
		System.out.println(passDao.remover(3L) ? "Sucesso ao remover" : "Ja removido ou inexistente");
		
	}

}
