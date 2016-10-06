package adli_prudhomme_observator;

import javax.swing.JFrame;

public class IHMLecture extends Observateur implements Runnable {

	private Controler _controler;
      
        public IHMLecture(Controler c){
            this._controler = c;
        }
        
        public void run(){
            while(true){
                System.out.println("IHMLecture");
                
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
		// TODO - implement IHMLecture.actualiser
		throw new UnsupportedOperationException();
	}

}