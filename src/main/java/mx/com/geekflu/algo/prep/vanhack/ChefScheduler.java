package mx.com.geekflu.algo.prep.vanhack;

import java.util.*;
import java.util.stream.Collectors;

public class ChefScheduler {
  public static boolean schedulable(HashMap<String, ArrayList<String>> requests) {
    String[] daysOfWeek = new String[] {"mon", "tue", "wed", "thu", "fri", "sat", "sun"};
    if (requests == null) {
      return false;
    }

    Map<String, Chef> chefs = new HashMap<>();
    for(String chefName : requests.keySet()) {
      chefs.put(chefName, Chef.create(chefName, requests.get(chefName)));
    }

    Map<String, Chef> chefsWorkingAllDays = getAllWeekWorkers(chefs);

    if(chefsWorkingAllDays.size() >= 3) {
      return true; // Does not mean this is well balanced
    }else {
      for(String dayOfweek : daysOfWeek) {
        boolean isDayCovered = false;
        Map<String, Chef> chefsByDay = getAvailableChefsByDay(chefs, dayOfweek);
        if (chefsByDay.size() <= 1) {
          return false;
        }else if(chefsByDay.size() == 2) {
          addWorkingDay(chefsByDay);
        }else if (chefsByDay.size() > 2) {
          addWrokingDay2ChefsWithLeastWorkingDays(chefsByDay);
        }
      }
    }
    return true;
  }

  private static void addWrokingDay2ChefsWithLeastWorkingDays(Map<String, Chef> chefs) {
    List<Chef> assignedDaysByChef = new ArrayList<>();

    for(Map.Entry<String, Chef> entry : chefs.entrySet()) {
      assignedDaysByChef.add(entry.getValue());
    }

    List<Chef> sortedChefs = assignedDaysByChef.stream()
      .sorted(Comparator.comparing(Chef::getAvailability))
      .collect(Collectors.toList());

    sortedChefs.get(0).incrementWorkingDay();
    sortedChefs.get(1).incrementWorkingDay();
  }

  public static void addWorkingDay(Map<String, Chef> chefs) {
    for(Map.Entry<String, Chef> entry : chefs.entrySet()) {
      Chef chef = entry.getValue();
      chef.incrementWorkingDay();
    }
  }

  public static Map<String, Chef> getAvailableChefsByDay(Map<String, Chef> chefs, String day) {
    Map<String, Chef> chefsByDay = new HashMap<>();
    for(Map.Entry<String, Chef> entry : chefs.entrySet()) {
      Chef chef = entry.getValue();
      if(chef.canWork(day)) {
        chefsByDay.put(entry.getKey(), chef);
      }
    }
    return chefsByDay;
  }

  public static Map<String, Chef> getAllWeekWorkers(Map<String, Chef> chefs) {
    Map<String, Chef> allWeekWorkers = new HashMap<>();
    for(Map.Entry<String, Chef> entry : chefs.entrySet()) {
      Chef chef = entry.getValue();
      if(chef.worksAllWeek()) {
        allWeekWorkers.put(entry.getKey(), chef);
      }
    }
    return allWeekWorkers;
  }

  public static Map<String, Chef> getOneDayWorkers(Map<String, Chef> chefs) {
    Map<String, Chef> oneDayWorkers = new HashMap<>();
    for(Map.Entry<String, Chef> entry : chefs.entrySet()) {
      Chef chef = entry.getValue();
      if(chef.isNotWorkingAtAll()) {
        oneDayWorkers.put(entry.getKey(), chef);
      }
    }
    return oneDayWorkers;
  }
}

class Chef {

  private Chef() {
  }

  private String name;
  private Map<String, Boolean> daysOff;
  private int daysAssigned;

  public static Chef create(String name, List<String> daysOff) {
    Chef _current = new Chef();
    _current.setName(name);
    if (daysOff != null) {
      _current.setDaysOff(daysOff.stream().collect(Collectors.toMap(dayOfWeek -> dayOfWeek, v -> Boolean.TRUE)));
    }else{
      _current.setDaysOff(new HashMap<>());
    }
    return _current;
  }

  public boolean worksAllWeek() {
    return daysOff.size() == 0;
  }

  public boolean isNotWorkingAtAll() {
    return daysOff.size() == 6;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setDaysOff(Map<String, Boolean> daysOff) {
    this.daysOff = daysOff;
  }

  public int getDaysAssigned() {
    return this.daysAssigned;
  }

  public void incrementWorkingDay() {
    this.daysAssigned++;
  }

  //7 - daysOff - assignedDays
  public int getAvailability() {
    return 7 - this.daysOff.size() - this.daysAssigned;
  }

  public boolean canWork(String day) {
    Boolean isDayOff = this.daysOff.get(day) != null ? Boolean.TRUE : Boolean.FALSE;
    if (this.daysAssigned >= 5) {
      return false;
    } else if(isDayOff) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public String toString() {
    return "Chef{" +
      "name='" + name + '\'' +
      ", daysOff=" + daysOff +
      ", daysAssigned=" + daysAssigned +
      '}';
  }
}