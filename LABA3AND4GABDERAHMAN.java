import java.util.ArrayList;
public class GameCharacter {
    private int health;
    private String eyeColor;
    private String skinColor;
    private ArrayList<String> skills;

    // Конструктор
    public GameCharacter(int health, String eyeColor, String skinColor) {
        this.health = health;
        this.eyeColor = eyeColor;
        this.skinColor = skinColor;
        this.skills = new ArrayList<>();
    }

    // Геттры и сеттры
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    // Метод добавления скилла
    public void acquireSkill(String skill) {
        skills.add(skill);
    }

    // Метод нанесение урона
    public void takeDamage(int damage) {
        health -= damage;
    }
    // Метод вывода данных о обьекте
    public String toString() {
        return "Игровой персонаж [" +
                "Здоровье=" + health +
                ", Цвет Глаз ='" + eyeColor + '\'' +
                ", Цвет кожи='" + skinColor + '\'' +
                ", Способности=" + skills +
                ']';
    }

    public static void main(String[] args) {
//Создаем новый обьект(Игровой Персонаж)
      GameCharacter character = new GameCharacter(100, "Зеленные", "белый");

//Добавляем 2 скила
        character.acquireSkill("Торнадо");
        character.acquireSkill("Магический ураган");

//Нанасем нашему персонажу 20 дамага
        character.takeDamage(20);

//С помощью метода туСтринг выводим параметры обьекта
        System.out.println(character.toString());
    }
}
