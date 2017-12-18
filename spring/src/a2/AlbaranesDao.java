package a2;


public interface AlbaranesDao {

	Albaranes getItem(int albaran);
	void updateItem(Albaranes albaran);

	void insertItem(Albaranes albaran);

	void deleteItem(int albaran);

}