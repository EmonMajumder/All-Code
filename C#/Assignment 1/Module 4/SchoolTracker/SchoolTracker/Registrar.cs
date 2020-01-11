using System;
using System.Collections.Generic;
using System.Text;

namespace SchoolTracker
{
    class Registrar
    {
        public List<IGraduate> grads;

        public Registrar(List<IGraduate> grads)
        {
            this.grads = grads;
        }

        public void graduateAll()
        {
            foreach(var graduate in grads)
            {
                graduate.graduate();
            }
        }
    }
}
