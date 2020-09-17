package cn.xpbootcamp.xunit;


    public class UserRepoFakeObject extends UserRepo {

        @Override
        public boolean getUserBy(String userName, String password) {
            return true;
        }

        @Override
        public void save(String userName, String password) {
        }
    }
