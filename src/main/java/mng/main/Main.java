//package mng.main;
import com.github.javafaker.Faker;
import mng.main.People;
import mng.main.People.Status;
import java.util.UUID;

void main() {
    IO.println("⚠️ Main ️️ ⚠️");

    List<People> people = generatePeople(50);

    IO.println("✅ for");
    for (People p: people) {
        IO.println("- " + p);
    }


    IO.println("\n✅ people.forEach");

    AtomicInteger index = new AtomicInteger(0);
    people.forEach(p -> {
                int i = index.getAndIncrement();
                IO.println(i + " -> " + p.toString());
            });




    IO.println("\n✅ people.stream() Status=" + Status.ACTIVE.name());

    List<People> peopleActive = people.stream()
            .filter(p -> Status.ACTIVE.equals(p.getStatus()))
            .toList();

    peopleActive.forEach(IO::println);
    IO.println("♦️ Pessoas.Status.ACTIVE: " + peopleActive.size());

}



static List<People> generatePeople(int quantidade) {
    List<People> listaUsuarios = new ArrayList<>();
    Faker faker = new Faker(new Locale("pt-BR"));
    for (int i = 1; i <= quantidade; i++) {
        listaUsuarios.add(new People(
                UUID.randomUUID().toString(),
                faker.name().fullName(),
                faker.internet().emailAddress(),
                getStatusRandom()));
    }
    return listaUsuarios;
}

static Status getStatusRandom() {
    Status[] values = Status.values();
    int index = new Random().nextInt(values.length);
    return values[index];
}
