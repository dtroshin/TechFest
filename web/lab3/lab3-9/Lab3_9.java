import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3_9 extends Applet implements ItemListener {
    public void init() {
        setLayout(new GridLayout(1, 0));

        CheckboxGroup dinnerType = new CheckboxGroup();
        standard = new Checkbox("standard", dinnerType, false);
        standard.addItemListener(this);
        deluxe = new Checkbox("deluxe", dinnerType, true);
        deluxe.addItemListener(this);

        CheckboxGroup appetizers = new CheckboxGroup();
        crepe = new Checkbox("crepe", appetizers, false);
        crepe.addItemListener(this);
        quiche = new Checkbox("quiche", appetizers, false);
        quiche.addItemListener(this);
        dumpling = new Checkbox("dumpling", appetizers, false);
        dumpling.addItemListener(this);

        CheckboxGroup soupOrSalad = new CheckboxGroup();

        soup = new Checkbox("Soup", soupOrSalad, false);
        soup.addItemListener(this);

        CheckboxGroup soups = new CheckboxGroup();
        cream = new Checkbox("cream", soups, false);
        cream.addItemListener(this);
        broth = new Checkbox("broth", soups, false);
        broth.addItemListener(this);
        gumbo = new Checkbox("gumbo", soups, false);
        gumbo.addItemListener(this);

        salad = new Checkbox("Salad", soupOrSalad, false);
        salad.addItemListener(this);

        CheckboxGroup salads = new CheckboxGroup();
        tossed = new Checkbox("tossed", salads, false);
        tossed.addItemListener(this);
        caesar = new Checkbox("caesar", salads, false);
        caesar.addItemListener(this);
        croutons = new Checkbox("croutons");
        croutons.addItemListener(this);
        lite = new Checkbox("lite dressing");
        lite.addItemListener(this);


        CheckboxGroup entrees = new CheckboxGroup();
        chicken = new Checkbox("chicken", entrees, false);
        chicken.addItemListener(this);
        beef = new Checkbox("beef", entrees, false);
        beef.addItemListener(this);
        lamb = new Checkbox("lamb", entrees, false);
        lamb.addItemListener(this);
        fish = new Checkbox("fish", entrees, false);
        fish.addItemListener(this);

        CheckboxGroup deserts = new CheckboxGroup();
        pie = new Checkbox("pie", deserts, false);
        pie.addItemListener(this);
        fruit = new Checkbox("fruit", deserts, false);
        fruit.addItemListener(this);
        sherbet = new Checkbox("sherbet", deserts, false);
        sherbet.addItemListener(this);


        setLayout(new GridLayout(0, 1));

        Panel p = new Panel();
        add(p);
        p.add(standard);
        p.add(deluxe);

        appetizerPanel = new Panel();
        add(appetizerPanel);
        appetizerPanel.add(new Label("Appetizer"));
        appetizerPanel.add(crepe);
        appetizerPanel.add(quiche);
        appetizerPanel.add(dumpling);

        soupPanel = new Panel();
        add(soupPanel);
        soupPanel.add(soup);
        soupPanel.add(cream);
        soupPanel.add(broth);
        soupPanel.add(gumbo);

        saladPanel = new Panel();
        add(saladPanel);
        saladPanel.add(salad);
        saladPanel.add(tossed);
        saladPanel.add(caesar);
        saladPanel.add(croutons);
        saladPanel.add(lite);


        entreePanel = new Panel();
        add(entreePanel);
        entreePanel.add(new Label("Entree"));
        entreePanel.add(chicken);
        entreePanel.add(beef);
        entreePanel.add(lamb);
        entreePanel.add(fish);

        desertPanel = new Panel();
		
        add(desertPanel);
        desertPanel.add(desert);
        desertPanel.add(pie);
        desertPanel.add(fruit);
        desertPanel.add(sherbet);
	}

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == standard || e.getSource() == deluxe)
            handleDinnerType((Checkbox)e.getSource());
        else if (e.getSource() == soup || e.getSource() == salad)
            handleSoupSaladChoice((Checkbox)e.getSource());
    }

    void handleDinnerType(Checkbox selectedType) {
        boolean enabled;
        if (selectedType == standard){
            enabled = false;
			remove(desertPanel);
			repaint();
		}
        else{
            enabled = true;
			add(desertPanel);
			repaint();
		}
		soup.setEnabled(enabled); 
		salad.setEnabled(enabled);
        pie.setEnabled(enabled);
        fruit.setEnabled(enabled);
        sherbet.setEnabled(enabled);
        cream.setEnabled(enabled);
        broth.setEnabled(enabled);
        gumbo.setEnabled(enabled);
        tossed.setEnabled(enabled);
        caesar.setEnabled(enabled);
        croutons.setEnabled(enabled);
        lite.setEnabled(enabled);
		
    }

    void handleSoupSaladChoice(Checkbox selectedCourse) {
        boolean soupEnabled, saladEnabled;
        if (selectedCourse == soup) {
            soupEnabled = true;
            saladEnabled = false;
        }
        else {
            soupEnabled = false;
            saladEnabled = true;
        }
        cream.setEnabled(soupEnabled);
        broth.setEnabled(soupEnabled);
        gumbo.setEnabled(soupEnabled);

        tossed.setEnabled(saladEnabled);
        caesar.setEnabled(saladEnabled);
        croutons.setEnabled(saladEnabled);
        lite.setEnabled(saladEnabled);
    }

	Label desert = new Label("Desert");
    Panel
        appetizerPanel, soupPanel, saladPanel, entreePanel, desertPanel;

    Checkbox
        standard, deluxe,
        soup, salad,
        crepe, quiche, dumpling,
        cream, broth, gumbo,
        tossed, caesar,
        croutons, lite,
        chicken, beef, lamb, fish,
        pie, fruit, sherbet;
}
