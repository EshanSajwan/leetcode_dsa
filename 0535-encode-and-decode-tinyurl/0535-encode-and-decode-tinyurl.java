public class Codec {

    Map<String , String> tinyValue = new HashMap<>();
    Map<String , String> longValue = new HashMap<>();
    final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 
    Random rand = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(tinyValue.containsKey(longUrl)) return tinyValue.get(longUrl);
        // 6 length ka ek String bana
        String tiny;
        do{
            StringBuilder sb = new StringBuilder("http://tinyurl.com/");
            for(int i = 0 ; i < 6 ; i++){
                sb.append(CHARS.charAt(rand.nextInt(62)));
            }
            tiny = sb.toString();
        }while(longValue.containsKey(tiny));
        
        tinyValue.put(longUrl , tiny);
        longValue.put(tiny , longUrl);

        return tinyValue.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return longValue.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));