package mx.com.geekflu.algo.prep.data.leetcode;

/**

 Given a valid (IPv4) IP address, return a defanged version of that IP address.
 A defanged IP address replaces every period "." with "[.]".

 Example 1:

 Input: address = "1.1.1.1"
 Output: "1[.]1[.]1[.]1"
 Example 2:

 Input: address = "255.100.50.0"
 Output: "255[.]100[.]50[.]0"


 */

public class DefangingIPAddress {

  public String defangIPaddr(String address) {
    if(address == null || address.length() <= 0) {
      return address;
    }
    StringBuilder stringBuilder = new StringBuilder();
    for(int j = 0; j < address.length(); j++) {
      if(address.charAt(j) == '.'){
        stringBuilder.append("[");
        stringBuilder.append(".");
        stringBuilder.append("]");
      }else {
        stringBuilder.append(address.charAt(j));
      }
    }
    return stringBuilder.toString();
  }

}
