package ai.standardaialgos.PSO;

/*public class Particle {

    private double[] position;
    private double[] velocity;
    private double[] bestPosition;

    public Particle(double[] position, double[] velocity) {
        this.position = new double[Constants.NUM_DIMENSIONS];
        this.velocity = new double[Constants.NUM_DIMENSIONS];
        this.bestPosition = new double[Constants.NUM_DIMENSIONS];

        System.arraycopy(position, 0,this.position, 0, position.length);
        System.arraycopy(velocity, 0,this.velocity, 0, velocity.length);
        //System.arraycopy(bestPosition, 0,this.bestPosition, 0, bestPosition.length);
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public double[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(double[] bestPosition) {
        this.bestPosition = bestPosition;
    }

    @Override
    public String toString() {
        return "Best Position so far : " + bestPosition[0] + "-" + bestPosition[1];
    }

    public void checkBestSolution(double[] globalBestSolution) {
        if(Constants.function(this.bestPosition) < Constants.function(globalBestSolution))
            globalBestSolution = this.bestPosition;
    }
}*/

public class Particle {

    private double[] position; // xi
    private double[] velocity; // vi
    private double[] bestPosition; // pi

    public Particle(double[] position, double[] velocity) {

        this.position = new double[Constants.NUM_DIMENSIONS];
        this.velocity = new double[Constants.NUM_DIMENSIONS];
        this.bestPosition = new double[Constants.NUM_DIMENSIONS];

        System.arraycopy(velocity, 0, this.velocity, 0, velocity.length);
        System.arraycopy(position, 0, this.position, 0, position.length);
        System.arraycopy(this.position, 0, this.bestPosition, 0, this.position.length);
    }

    double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    double[] getBestPosition() {
        return bestPosition;
    }

    void setBestPosition(double[] bestPosition) {
        System.arraycopy(bestPosition, 0, this.bestPosition, 0, bestPosition.length);
    }

    void checkBestSolution(double[] globalBestSolution) {

        if (Constants.function(this.bestPosition) < Constants.function(globalBestSolution)) {
            globalBestSolution = this.bestPosition;
        }
    }

    public String toString() {
        return "Best position so far: " + this.bestPosition[0] + ","
                + this.bestPosition[1] + "," + this.bestPosition[2];
    }
}
