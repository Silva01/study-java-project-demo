package silva.daniel.project.study.injection1;

import silva.daniel.project.study.injection1.annotations.LoadFactory;

@LoadFactory
public class Factory {
  public void run() {
    System.out.println("Factory.run");
  }
}
