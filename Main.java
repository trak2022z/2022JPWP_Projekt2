import java.util.Scanner;

// link do wyjasnienia działania programu
/*
https://zadania.dlamaturzysty.info/s/5159/81431-informatyka/5040155-zadania-z-informatyki-Tworzenie-algorytmow.htm?podstr=2#:~:text=Wi%C4%85zka%20zada%C5%84%20Liczba%20narcystyczna
*/
public class Main {

  public static Scanner s = new Scanner(System.in);

  // zamiana liczby na wybrany system liczbowy
  public static String na_system(int liczba, int system) {
    // utworzenie tablicy o rozmiarze systemu
    int rozmiar[] = new int[system];
    // wypelnienie kolejnymi liczbami systemu
    for (int i = 0; i < rozmiar.length; i++) {
      rozmiar[i] = i;
    }
    int temp;
    String wynik = "";
    // dodawanie liczby do wyniku
    while (liczba > 0) {
      temp = liczba % system;
      wynik = rozmiar[temp] + wynik;
      liczba = liczba / system;
    }
    return wynik;
  }

  public static boolean narcystyczna(String liczba, int system) {
    // sprawdzamy B-narcystycznosc liczby wedlug algorytmu
    String temp = na_system(Integer.parseInt(liczba), system);
    // dzielimy liczbe na cyfry
    String[] cyfry = temp.split("");
    int dl = temp.length();
    int x = dl - 1;
    int suma1 = 0, suma2 = 0;
    // dla kazdej cyfry tworzymy 2 sumy
    // jedna poprzez pomnozenie tej cyfry i potegi systemu
    // druga stala potega systemu-1
    for (int i = 0; i < dl; i++) {
      int cyfra = Integer.parseInt(cyfry[i]);
      suma1 += cyfra * Math.pow(system, x);
      suma2 += Math.pow(cyfra, system - 1);
      if (x < 0)
        x = 0;
      else
        x--;
    }
    // jesli spelniony jest warunek narcystycznosci czyli obie sumy sa rowne liczbie
    // dziesietnej
    if ((suma1 == Integer.parseInt(liczba)) && (suma2 == Integer.parseInt(liczba)))
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    System.out.println("Podaj liczbe dziesietna: ");
    String liczba = s.nextLine();
    System.out.println("Podaj B: ");
    int B = s.nextInt();
    System.out.println("Czy liczba " + liczba + " jest " + B + "-narcystyczna? " + narcystyczna(liczba, B));
    s.close();
  }

}