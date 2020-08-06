package explore.topics.design.aRepository;

public class RepoPattern {
}

//The record we are loading out of our database is PersonModel.
class PersonModel {
    public String Name;
    public int Age;
}

//The service that is loading a person out of the database is ICompanyLogic.
interface ICompanyLogic {
    PersonModel GetPersonByName(String name);
    CompanyModel GetCompanyByName(String companyName);
}

// business service CompanyLogic that can retrieve a single person from the database.
class CompanyLogic implements ICompanyLogic {
    private IPersonDataContext personDataContext;
    private ICompanyDataContext companyDataContext;

    public CompanyLogic(IPersonDataContext personDataContext, ICompanyDataContext companyDataContext) {
        this.personDataContext = personDataContext;
        this.companyDataContext = companyDataContext;
    }

    @Override
    public PersonModel GetPersonByName(String name) {
        return personDataContext.findPerson();
    }

    @Override
    public CompanyModel GetCompanyByName(String companyName) {
        return companyDataContext.findPerson();
    }
}

//we have a new requirement that says we also need a way to load a
// company from another database.
// So we need to add a new method and extend CompanyLogic.

class CompanyModel {
    public String Name;
    public int Size;
    public boolean Public;
}