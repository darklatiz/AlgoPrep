package mx.com.geekflu.algo.prep.binary.search;

/**
 * Basicamente construir objetos es mi objetivo
 */
public class Construction {

  public static void main(String[] args) {
    Zapato zapato = new Zapato();
    Zapato zapato2 = new Zapato(10, "Rojo", "MOdelo Sierra", 23);
    System.out.println("Zapato   = " + zapato);
    System.out.println("Zapato 2 = " + zapato2);

    zapato.setColor("Rojo");
    zapato.setModelo("Modelo");
    zapato.setStock(23);
    zapato.setTalla(12);

    System.out.println("Zapato   = " + zapato);

    ZapatoDama zapatoDama = new ZapatoDama();

    zapatoDama.setColor("Gris");
    zapatoDama.setMedidaTacon(34);
    System.out.println("Zapato dama = " + zapatoDama);
    System.out.println(zapatoDama.calculaPrecio());

    ZapatoDama zapatoDama1 = new ZapatoDama(8, "Verde", "Modelo", 45);
    System.out.println(zapatoDama1);
    System.out.println(zapatoDama1.calculaPrecio());

  }

}


class Zapato {
  private int talla;
  private String color;
  private String modelo;

  private Integer stock;

  public Zapato(){

  }

  public Zapato(int talla, String color, String modelo, Integer stock) {
    this.talla = talla;
    this.color = color;
    this.modelo = modelo;
    this.stock = stock;
  }

  public float calculaPrecio() {
    if(this.getTalla() <= 0  && this.getStock() == null) {
      throw new RuntimeException("Valores necesarios para calcular precio no estan seteados");
    }
    return (float) (234.5 * this.getTalla() / this.getStock());
  }

  public String existeEnTienda(String codigoTienda) {
    // consulto base de datos para ver en que tienda esta y regreso la mas cercana
    return null;
  }

  public int getTalla() {
    return talla;
  }

  public void setTalla(int talla) {
    this.talla = talla;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  @Override
  public String toString() {
    return "Zapato{" +
      "talla=" + talla +
      ", color='" + color + '\'' +
      ", modelo='" + modelo + '\'' +
      ", stock='" + stock + '\'' +
      '}';
  }
}

class ZapatoDama extends Zapato {
  private int medidaTacon;

  public ZapatoDama(){}

  public ZapatoDama(int sTalla, String sColor, String sModelo, int sStock) {
    super(sTalla, sColor, sModelo, sStock);
    this.medidaTacon = 12;
  }

  @Override
  public String toString() {
    return "ZapatoDama{" +
      "medidaTacon=" + medidaTacon + ", " +
       super.toString() +
      '}';
  }

  public int getMedidaTacon() {
    return medidaTacon;
  }

  public void setMedidaTacon(int medidaTacon) {
    this.medidaTacon = medidaTacon;
  }
}

class ZapatoHombre extends Zapato {
  private boolean isPiel;
}