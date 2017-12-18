package a2;
import java.util.Scanner;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

@SuppressWarnings("deprecation")
public class AlbaranesDaoTest extends AbstractTransactionalDataSourceSpringContextTests{

	private AlbaranesDao albaranesDao;

	public void setAlbaranesDao(AlbaranesDao albaranesDao) {
		this.albaranesDao = albaranesDao;
	}


	protected String[] getConfigLocations() {
		this.setAutowireMode(AUTOWIRE_BY_NAME);
		return new String[] {"applicationContext-testAlbaranes.xml"};
	}

	public void testGetItem() {
		int setAlbaran;
		Scanner sc = new Scanner(System.in);
		this.setDefaultRollback(false);
		System.out.println("Escribe el numero del albaran");
		setAlbaran = sc.nextInt();

		Albaranes itemResult = albaranesDao.getItem(setAlbaran);

		assertNotNull(itemResult);
		System.out.println("Albaran:  "+itemResult.getAlbaran()+" \nCliente:  "+itemResult.getCliente()+" \nPagado:  "+itemResult.getEstado()+" \nForma de pago:  "+itemResult.getPago());

	}
	public void testInsertItem() {
		this.setDefaultRollback(false);
		Albaranes alba = new Albaranes();

		Scanner teclado = new Scanner(System.in);
		
		int numeroAlbaran,numeroCliente;
		String estado, formpago;
		
		System.out.println("Introduce un numero de albaran para introducir: ");
		numeroAlbaran=teclado.nextInt();
		
		System.out.println("Introduce un numero de cliente para introducir:");
		numeroCliente=teclado.nextInt();
		
		System.out.println("Introduce un estado de albaran para introducir: ");
		estado=teclado.nextLine();
		
		System.out.println("Introduce una forma de pago de albaran para introducir:");
		formpago=teclado.nextLine();

		alba.setAlbaran(numeroAlbaran);
		alba.setCliente(numeroCliente);
		alba.setEstado(estado);
		alba.setPago(formpago);
		try{
			albaranesDao.insertItem(alba);

			Albaranes itemResult = albaranesDao.getItem(alba.getAlbaran());

			assertEquals(alba.getAlbaran(), itemResult.getAlbaran());
			System.out.println("Albaran "+ alba.getAlbaran()+" insertado");
		}catch(Exception e){
			System.out.println("El albaran "+alba.getAlbaran()+" ya existe");
		}
	}
	public void testDeleteItem() {
		this.setDefaultRollback(false);

		Albaranes alba = new Albaranes();
		alba.setAlbaran(58);
		alba.setCliente(15);
		alba.setEstado("S");
		alba.setPago("C");
		try{
			Albaranes itemResult = albaranesDao.getItem(alba.getAlbaran());

			assertEquals(alba.getAlbaran(), itemResult.getAlbaran());
			albaranesDao.deleteItem(alba.getAlbaran());

			System.out.println("Albaran "+ alba.getAlbaran()+" eliminado");


			//si la ejecucion llega aqui significa que el delete se ha efectuado correctamente
			assertTrue(true);
		}catch(Exception e){
			System.out.println("El albaran "+ alba.getAlbaran()+" no existe");
		}
	}

}