package ai.standardaialgos.PSO;

public class ParticleSwarmOptimisation {

    private double[] globalBestSolution;
    private Particle[] particleSwarm;
    private int epochs;

    public ParticleSwarmOptimisation() {
        this.globalBestSolution = new double[Constants.NUM_DIMENSIONS];
        this.particleSwarm = new Particle[Constants.NUM_PARTICLES];
        generateRandomSolution();
    }

    private void generateRandomSolution() {

        //double randomCoordinate;
        for (int i = 0; i < Constants.NUM_DIMENSIONS; i++) {
            double randomCoordinate = random(Constants.MIN, Constants.MAX);
            this.globalBestSolution[i] = randomCoordinate;
        }
    }

    private double random(double min, double max) {
        return min + (max - min) * Math.random();
    }

    private double[] initialiseLocation() {
        double x = random(Constants.MIN, Constants.MAX);
        double y = random(Constants.MIN, Constants.MAX);

        return new double[]{x, y};
    }

    private double[] initialiseVelocity() {
        double vX = random(-(Constants.MAX - Constants.MIN), Constants.MAX - Constants.MIN);
        double vY = random(-(Constants.MAX - Constants.MIN), Constants.MAX - Constants.MIN);

        return new double[]{vX, vY};
    }

    public void showSolution() {
        System.out.println("Solution for PSO problem!");
        System.out.println("Best Solution - x : " + this.globalBestSolution[0] + ", y : " + this.globalBestSolution[1]);
        System.out.println("Value function(x, y) : " + Constants.function(this.globalBestSolution));
    }

    public void solve() {

        //double[] locations;
        //double[] velocities;

        //double rp;
        //double rg;

        for (int i = 0; i < Constants.NUM_PARTICLES; i++) {
            double[] locations = initialiseLocation();
            double[] velocities = initialiseVelocity();

            this.particleSwarm[i] = new Particle(locations, velocities);
            this.particleSwarm[i].checkBestSolution(this.globalBestSolution);
        }

        while (this.epochs < Constants.MAX_ITERATIONS) {
            for (Particle particle : this.particleSwarm) {

                //Update the velocities
                for (int i = 0; i < particle.getVelocity().length; i++) {
                    double rp = Math.random();
                    double rg = Math.random();

                    particle.getVelocity()[i] = Constants.w * particle.getVelocity()[i] +
                            Constants.c1 * rp * (particle.getBestPosition()[i] - particle.getPosition()[i]) +
                            Constants.c2 * rg * (this.globalBestSolution[i] - particle.getPosition()[i]);
                }

                //Update the positions
                for (int i = 0; i < particle.getPosition().length; i++) {
                    particle.getPosition()[i] += particle.getVelocity()[i];

                    if (particle.getPosition()[i] < Constants.MIN)
                        particle.getPosition()[i] = Constants.MIN;
                    else if (particle.getPosition()[i] > Constants.MAX)
                        particle.getPosition()[i] = Constants.MAX;
                }

                if (Constants.function(particle.getPosition()) > Constants.function(particle.getBestPosition()))
                    particle.setBestPosition(particle.getPosition());

                if (Constants.function(particle.getBestPosition()) > Constants.function(this.globalBestSolution))
                    System.arraycopy(particle.getBestPosition(), 0, this.globalBestSolution, 0, particle.getBestPosition().length);
            }

            this.epochs++;
        }
    }
}

