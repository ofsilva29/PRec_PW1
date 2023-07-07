package testes;

import dao.*;

public class TesteBuscaAtributos {
    public static void main(String[] args) {
    	
    
        PassageiroDAO eiro = new PassageiroDAO();

        VooDAO voo = new VooDAO();

        PassagemDAO pass = new PassagemDAO();

        AeroportoDAO aero = new AeroportoDAO();

        System.out.println("\n" + "---BUSCA DE PASSAGEIRO---"+ "\n" + eiro.buscarPorNome("Manoel Silva"));
        
          
        System.out.println("---BUSCA POR NUMERO DO VOO---"+ "\n");

        System.out.println(voo.buscarPorNumero(2903));
        
        System.out.println("---BUSCA POR ID PESSOA---");

        System.out.println(pass.buscarIdPessoa(1L,1L));

        System.out.println("---BUSCA DA CLASSIFICACAO POR ID PASSAGEM E ID PESSOA---"+ "\n");
        
        System.out.println(voo.buscarIdVoo(1L, 1L));

        System.out.println("---BUSCA DA CLASSIFICACAO POR CIDADE---"+ "\n");

        System.out.println(aero.buscarPorCidade("Rio de Janeiro"));

    }
}
