package testes;

import dao.*;
import enums.Situacao;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import classes.*;

public class TesteBuscaAtualizar {
	public static void main(String[] args) {
		
			
		
		PassagemDAO passDao = new PassagemDAO();
		Passagem pass = new Passagem();
		pass = passDao.buscarID(1L);
		System.out.println("\n" + "PASSAGEM ANTES DA ATUALIZACAO: \n" + pass);
		
		 		
		VooDAO vooDao = new VooDAO();
		Voo voo = new Voo();
		voo = vooDao.buscarID(1L);
		System.out.println("VOO ANTES DA ATUALIZACAO: \n\n" + voo);
		voo.setOrigem(10);
		voo.setDestino(10);
		voo.setNumero(300);
		voo.setAeroporto(new Aeroporto("Curitiba", false, false));
		
		
		voo.atualizar(voo);
		voo = vooDao.buscarID(1L);
		System.out.println("VOO DPEOIS DA ATUALIZACAO: \n\n" + voo);	
		
	   
		AeroportoDAO aeroDao = new AeroportoDAO();
		Aeroporto aero = new Aeroporto();
		aero = aeroDao.buscarID(2L);
		System.out.println("CLASSIFICACAO ANTES DA ATUALIZACAO: \n\n" + aero);
		aero.setNome(false);
		aero.setCidade("Curitiba");
		
		aeroDao.atualizar(aero);
		aero = aeroDao.buscarID(2L);
		System.out.println("CLASSIFICACAO DEPOIS DA ATUALIZACAO: \n\n" + aero);
		
		
		PassageiroDAO eiroDao = new PassageiroDAO();
		Passageiro eiro = new Passageiro();
		eiro = eiroDao.buscarID(1L);
		System.out.println("PASSAGEIRO ANTES DA ATUALIZACA: \n\n" + eiro);
		eiro.setNome("Manoel Silva");
	
	
		List<Voo> vooEiro = new LinkedList<>();
		vooEiro.add(vooDao.buscarID(2L));
		vooEiro.add(vooDao.buscarID(3L));
		List<Passagem> passagem = new LinkedList<>();
		passagens.add(new Passagem(eiro, vooEiro));
		eiro.setPassagem(passagem);
		
		eiroDao.atualizar(eiro);
		eiro = eiroDao.buscarID(1L);
		System.out.println("PASSAGEIRO DEPOIS DA ATUALIZACA: \n\n" + eiro);
						
	}

}
