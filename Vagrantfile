Vagrant.configure(2) do |config|
  
  config.vm.box = "ubuntu/trusty64"
  #config.vm.box = "hashicorp/precise32"
  config.vm.provision "shell", path: "vag-setup.sh"

  config.vm.network "private_network", ip: "192.168.33.10"
end