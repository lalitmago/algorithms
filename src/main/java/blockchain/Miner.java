package blockchain;

public class Miner {
    private double reward;

    void mine(Block block, BlockChain blockChain) {

        while (notGoldenHash(block)) {
            block.generateHash();
            block.incrementNonce();
        }

        System.out.println(block + " has just been mined...");
        System.out.println("Hash is : " + block.getHash());

        blockChain.addBlock(block);
        reward += Constants.MINER_REWARD;
    }

    private boolean notGoldenHash(Block block) {
        String leadingZeroes = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
        //System.out.println(block.getHash());
        return !block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeroes);
    }

    double getReward() {
        return this.reward;
    }
}
