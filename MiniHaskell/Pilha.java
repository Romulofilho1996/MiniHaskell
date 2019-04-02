import java.util.*;
public class Pilha {

  private List<String> objetos = new LinkedList<String>();

  public void insere(String objeto) {
    this.objetos.add(objeto);
  }

  public String remove() {
    return this.objetos.remove(this.objetos.size() - 1);
  }

  public boolean vazia() {
    return this.objetos.size() == 0;
  }

  public String get() {
    return this.objetos.get(objetos.size()-1);
  }

}