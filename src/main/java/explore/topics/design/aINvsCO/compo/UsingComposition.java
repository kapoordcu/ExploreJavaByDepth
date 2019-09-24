package explore.topics.design.aINvsCO.compo;


class UsingComposition {
    public static void main(String[] args) {
        BackendDeveloper backendDeveloper = new BackendDeveloper();
        int skillsCount = backendDeveloper.getSkillsCount();
        // Now getSkillsCount returns Technologies, Contract broken
    }
}

class Developer { // Even Method in superclass changes
    public Technologies getSkillsCount() {
        System.out.println("Technologies are appealing.");
        return new Technologies(5);
    }
}

class BackendDeveloper { // Although the change was rippled to Base class but did not effect
    // the client interface of base class
    private Developer developer;

    public int getSkillsCount() {
        Technologies technologies = developer.getSkillsCount();
        return technologies.getSkillsCount();
    }
}

class Technologies {
    private int skillsCount;
    public Technologies(int knownCount) {
        this.skillsCount = knownCount;
    }
    public int getSkillsCount() {
        return skillsCount;
    }
}