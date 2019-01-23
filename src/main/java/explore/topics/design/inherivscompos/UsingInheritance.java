package explore.topics.design.inherivscompos;

class UsingInheritance {
    public static void main(String[] args) {
        BackendDeveloper backendDeveloper = new BackendDeveloper();
        /* BROKEN if the return type of getSkillsCount changes */
        // int skillsCount = backendDeveloper.getSkillsCount();
    }
}

class Developer {
//    public int getSkillsCount() {
//        System.out.println("Technologies are appealing.");
//        return 3;
//    }
    // Now getSkillsCount returns Technologies , NOT int
    public Technologies getSkillsCount() {
        System.out.println("Technologies are appealing.");
        return new Technologies(5);
    }
}

class BackendDeveloper extends Developer {

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