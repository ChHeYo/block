import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class BlockChain implements Validation{

    private static ArrayList<Block> blockChain = new ArrayList<Block>();
    private static int difficulty = 4;

    public static void main(String[] args){

        addGenesisBlock();
        addBlock("Second Block");
        addBlock("Third Block");

        Validation.blockChainValidation(blockChain);

        // JSON Object
        String jsonBlockChain = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(jsonBlockChain);
    }

    public static void addGenesisBlock(){
        blockChain.add(new Block("0", "First Block"));
        System.out.println("Commence Mining");
        blockChain.get(0).mine(difficulty);
    }

    public static void addBlock(String data){
        blockChain.add(new Block(blockChain.get(blockChain.size()-1).getHash(), data));
        System.out.println("Commence Mining");
        blockChain.get(blockChain.size()-1).mine(difficulty);
    }
}

