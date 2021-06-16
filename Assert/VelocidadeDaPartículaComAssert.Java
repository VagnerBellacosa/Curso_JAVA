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
		Integer velocidadeParticula = retornarVelocidadeParticula(12,
		QUILOMETROS_POR_SEGUNDO);

		assert(velocidadeParticula < VELOCIDADE_LUZ):
		"Velocidade da particula não pode ser maior que a velocidade da luz";

	}
}