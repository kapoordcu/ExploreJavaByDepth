package explore.topics.design.inherivscompos;


class UsingComposition {
    public static void main(String[] args) {
        BackendDeveloper_1 backendDeveloper = new BackendDeveloper_1();
        int skillsCount = backendDeveloper.getSkillsCount();
        // Now getSkillsCount returns Technologies, Contract broken
    }
}

class Developer_1 { // Even Method in superclass changes
    public Technologies getSkillsCount() {
        System.out.println("Technologies are appealing.");
        return new Technologies(5);
    }
}

class BackendDeveloper_1 { // Although the change was rippled to Base class but did not effect
    // the client interface of base class
    private Developer_1 developer_1;

    public int getSkillsCount() {
        Technologies technologies = developer_1.getSkillsCount();
        return technologies.getSkillsCount();
    }
}