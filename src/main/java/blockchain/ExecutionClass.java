package blockchain;

public class ExecutionClass {
    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();
        Miner miner = new Miner();

        Block block0 = new Block(0, "transaction1", Constants.GENESIS_PREVIOUS_HASH);
        miner.mine(block0, blockChain);

        Block block1 = new Block(1, "transaction2", blockChain.getBlockChain().get(blockChain.size() - 1).getHash());
        miner.mine(block1, blockChain);

        Block block2 = new Block(2, "transaction3", blockChain.getBlockChain().get(blockChain.size() - 1).getHash());
        miner.mine(block2, blockChain);

        System.out.println(System.lineSeparator() + "BLOCKCHAIN: " + System.lineSeparator() + blockChain);
        System.out.println("Miner's reward : " + miner.getReward());
    }
}
