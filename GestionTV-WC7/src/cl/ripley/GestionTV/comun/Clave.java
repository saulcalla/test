package cl.ripley.GestionTV.comun;

public class Clave
{
  private String password;

  public void setPassword(String password)
  {
    this.password = password;
  }
  public String getPassword() {
    return this.password;
  }
  public void codifica(String password) {
    this.password = password;

    char x1 = '0';
    char x2 = '0';
    char x3 = '0';
    char x4 = '0';
    char x5 = '0';
    char x6 = '0';

    int lon = password.length();
    switch (lon) {
    case 0:
      break;
    case 1:
      x1 = password.charAt(0);
      break;
    case 2:
      x1 = password.charAt(0);
      x2 = password.charAt(1);
      break;
    case 3:
      x1 = password.charAt(0);
      x2 = password.charAt(1);
      x3 = password.charAt(2);
      break;
    case 4:
      x1 = password.charAt(0);
      x2 = password.charAt(1);
      x3 = password.charAt(2);
      x4 = password.charAt(3);
      break;
    case 5:
      x1 = password.charAt(0);
      x2 = password.charAt(1);
      x3 = password.charAt(2);
      x4 = password.charAt(3);
      x5 = password.charAt(4);
      break;
    case 6:
      x1 = password.charAt(0);
      x2 = password.charAt(1);
      x3 = password.charAt(2);
      x4 = password.charAt(3);
      x5 = password.charAt(4);
      x6 = password.charAt(5);
    }

    String c0 = "?&yWB4y" + x1 + "&.2;345";
    String c1 = "3+xH%w" + x2;
    String c2 = ";E5&!(2i" + x3 + "a253W";
    String c3 = "P5" + x4 + "78&";
    String c4 = "v$3" + x5;
    String c5 = x6 + "&%$!3KL,";

    setPassword(c4 + c3 + c5 + c0 + c2 + c1);
  }
}