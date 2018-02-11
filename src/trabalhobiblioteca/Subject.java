package trabalhobiblioteca;

public interface Subject {
	public void registerObserver(ObserverLivro obLivro);
	public void removeObserver(ObserverLivro obLivro);
	public void notifyObservers();
}
