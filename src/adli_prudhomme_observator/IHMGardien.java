package adli_prudhomme_observator;

public class IHMGardien extends Observateur implements Runnable {

	private Controler _controler;

	public IHMGardien(Controler c){
            this._controler = c;
        }
        
        public void run(){
            while(true){
                System.out.println("IHMGardien");
                
                // Pour endormir un thread
                /*try {
                    this.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
        
        /**
	 * @param o
	 * @param c
	 */
	public void actualiser(Observable o, Controler c) {
		// TODO - implement IHMGardien.actualiser
		throw new UnsupportedOperationException();
	}

}