public class Anagrama {
    public static boolean isAnagrama(String palabra1, String palabra2) {
        boolean isAnagrama=false;

        if(palabra1.length()!=palabra2.length()){
            return false;
        }else {

            for (int i = 0; i < palabra1.length(); i++) {
                for (int j = 0; j < palabra2.length(); j++) {
                    if(palabra2.contains(String.valueOf(palabra1.charAt(i)))){
                        if (palabra1.charAt(i)==palabra2.charAt(j)) {
                            isAnagrama = true;
                            break;
                        } else {
                            isAnagrama = false;
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return isAnagrama;
    }

}
