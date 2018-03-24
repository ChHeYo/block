import java.util.Date;

public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private long timestamp;
    private int nonce;

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String getHash() {
        return hash;
    }

    public String calculateHash() {
        /* hash the information inside the block
        and assigned the encrypted information to hash */
        String hashResult = Hashlib.hash256Encryption(
                previousHash + data + nonce +Long.toString(timestamp)
        );
        return hashResult;
    }

    public void mine(int difficulty){
        /* create a new string from a char array of size 'difficulty'
        with the number of 0 equal to the parameter */
        String goal = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring(0, difficulty).equals(goal)){
            // rehash the hash until we achieve desired number of zeros at the head
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block has been successfully mined!");
    }
}
