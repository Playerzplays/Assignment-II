/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Newbie
 */
class Mage extends Character {
    private String elementalAffinity;

    public Mage(String characterID, String characterName, int level, String elementalAffinity) {
        super(characterID, characterName, level);
        this.elementalAffinity = elementalAffinity;
    }

    public String getElementalAffinity() {
        return elementalAffinity;
    }

    public void setElementalAffinity(String elementalAffinity) {
        this.elementalAffinity = elementalAffinity;
    }

    public void castElementalSpell(String spellType) {
        System.out.println("\nElara casts the Teleportation spell");
        if(getHealth()<= 0){
            System.out.println(getCharacterName() + " can't perform the action. The character is dead.");
            return;
        }
        
        if (getLevel() < 5) {
            System.out.println(getCharacterName() + " needs to reach level 5 before casting any spells.\n");
        } else {
            switch (spellType) {
                case "Teleportation":
                    System.out.println("Teleporting " + getCharacterName() + " out of danger!\n");
                    break;
                case "Illusion":
                    System.out.println(getCharacterName() + " is creating illusions to confuse the enemy.\n");
                    break;
                case "Detection":
                    System.out.println(getCharacterName() + " is detecting the presence of magic nearby...\n");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        String status = "Alive";
        if(getHealth()<= 0){
            status = "Dead";
        }
        
        StringBuilder skillsString = new StringBuilder("Skills: ");
        for (Skill skill : getSkills()) {
            skillsString.append(skill.getSkillName()).append(", ");
        }
        if (skillsString.length() > 2) {
            skillsString.setLength(skillsString.length() - 2); // Remove the trailing ", "
        }
        
        return "(Mage) " +
               "\nCharacter ID: " + getCharacterID() +
               "\nName: " + getCharacterName() +
               "\nLevel: " + getLevel() +
               "\nHealth: " + getHealth() +
               "\nStatus: " + status +
               "\nElemental Affinity: " + getElementalAffinity() +
               "\n" + skillsString.toString() + 
               "\n";
    }
}
