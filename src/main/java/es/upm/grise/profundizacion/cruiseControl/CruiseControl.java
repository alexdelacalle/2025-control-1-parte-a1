package es.upm.grise.profundizacion.cruiseControl;

public class CruiseControl {
	
	@SuppressWarnings("unused")
	private Speedometer speedometer;
	private Integer speedSet;
	private Integer speedLimit;

	/*
	 * Constructor
	 */
	public CruiseControl(Speedometer speedometer) {
		
		this.speedometer = speedometer;
		this.speedSet= null;
		this.speedLimit= null;

	}
	
	/*
	 * Method to code
	 */
	public void setSpeedSet(int speedSet) throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException{
		if (speedSet>0) {
			if (this.speedLimit==null) {
				throw new SpeedSetAboveSpeedLimitException("SpeedLimit es null");
			}else {
				if(this.speedLimit>this.speedSet) {
					this.speedSet= speedSet;
					
				}else {
					throw new SpeedSetAboveSpeedLimitException("SpeedSet tiene que ser menor que speedLimit");
				}
			}
		}else {
			throw new IncorrectSpeedSetException("La velocidad debe ser mayor que 0 estrictamente");
		}
	}

	/*
	 * Other setters & getters
	 */
	public Integer getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	public Integer getSpeedSet() {
		return speedSet;
	}

}
