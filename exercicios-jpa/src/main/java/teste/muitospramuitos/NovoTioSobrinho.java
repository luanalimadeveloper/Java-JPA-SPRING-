package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {
	
	public static void main(String[] args) {
		Tio tia1 = new Tio("Luana");
		Tio tia2 = new Tio("Graci");
		
		Sobrinho sobrinho1 = new Sobrinho("Davi");
		Sobrinho sobrinha2 = new Sobrinho("Eloa");
		
		tia1.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tia1);
		tia1.getSobrinhos().add(sobrinha2);
		sobrinha2.getTios().add(tia1);
		tia2.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tia2);
		tia2.getSobrinhos().add(sobrinha2);
		sobrinha2.getTios().add(tia2);
		
		DAO<Object> dao = new DAO<>();
		dao.abrirT()
			.incluir(tia1)
			.incluir(tia2)
			.incluir(sobrinho1)
			.incluir(sobrinha2)
			.fecharT()
			.fechar();
	}

}
