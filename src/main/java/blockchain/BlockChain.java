package blockchain;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    private List<Block> blockChain;

    BlockChain() {
        this.blockChain = new ArrayList<>();
    }

    void addBlock(Block block) {
        this.blockChain.add(block);
    }

    List<Block> getBlockChain() {
        return this.blockChain;
    }

    int size() {
        return this.blockChain.size();
    }

    @Override
    public String toString() {
        StringBuilder blockChain = new StringBuilder();

        for (Block block : this.blockChain) {
            blockChain.append(block.toString());
            blockChain.append(System.lineSeparator());
            //blockChain += block.toString() + System.lineSeparator();
        }

        return blockChain.toString();
    }
}
