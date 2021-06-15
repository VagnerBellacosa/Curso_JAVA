// Testando velocidade da partícula sem Assert

package br.com.odontonew.bean;

public class CalculadorParticula {

	private static final Integer QUILOMETROS_POR_SEGUNDO = 0;
	private static final Integer METROS_POR_SEGUNDO = 1;
	private static final Integer VELOCIDADE_LUZ = 300000;

	/**
	 * @param args
	 * @throws
	 */
	public static void main(String[] args) {

		//Em KM/s
		Integer velocidadeParticula =
		retornarVelocidadeParticula(12, QUILOMETROS_POR_SEGUNDO);

		try{
			if (velocidadeParticula > VELOCIDADE_LUZ)
				throw new Exception("Velocidade da Particula não pode
				ser maior que a velocidade da Luz");

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}