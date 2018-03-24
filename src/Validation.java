import java.util.ArrayList;

/* Basic validation check to see if the current hash's previous hash value
equals the actual hash of the previous hash.
In other words,

| block0.hash | == |block1.previousHash|

 */

public interface Validation {

    public static boolean blockChainValidation(ArrayList<Block> blockChain){

        for(int i = 1; i < blockChain.size(); i++){
            Block previousBlock = blockChain.get(i-1);
            Block currentBlock = blockChain.get(i);
            if (currentBlock.getHash().equals(previousBlock.getHash())){
                System.out.println("This chain has been poisoned!");
                return false;
            }
        }
        System.out.println("The blockchain is valid");
        return true;
    }
}
